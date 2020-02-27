package attendance.manas.edu.kg.algo;

import com.machinezoo.sourceafis.FingerprintImage;
import com.machinezoo.sourceafis.FingerprintTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FingerprintAlgo {

    private final double threshold = 40;

    public byte[] getImageByte(MultipartFile image) {
        byte[] serialized = null;
        try {
            byte[] probeImage = image.getBytes();
            FingerprintTemplate probe = new FingerprintTemplate(
                    new FingerprintImage()
                            .dpi(500)
                            .decode(probeImage));
            serialized = probe.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return serialized;
    }

    public FingerprintTemplate getTemplateFromImage(MultipartFile image) {
        FingerprintTemplate probe = null;
        try {
            byte[] probeImage = image.getBytes();
            probe = new FingerprintTemplate(
                    new FingerprintImage()
                            .dpi(500)
                            .decode(probeImage));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return probe;
    }

}
