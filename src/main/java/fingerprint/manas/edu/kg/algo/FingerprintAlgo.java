package fingerprint.manas.edu.kg.algo;

import com.machinezoo.sourceafis.FingerprintImage;
import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;
import fingerprint.manas.edu.kg.entity.StudentDetail;
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

        }catch (Exception e){
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

        }catch (Exception e){
            e.printStackTrace();
        }
        return probe;
    }

    public Integer find(FingerprintTemplate probe, Iterable<StudentDetail> candidates) {
        Integer id = null;
        FingerprintMatcher matcher = new FingerprintMatcher()
                .index(probe);
        double high = 0;
        for (StudentDetail candidate : candidates) {
            byte[] arr = candidate.getFingerprint();
            FingerprintTemplate template  = new FingerprintTemplate(arr);
            double score = matcher.match(template);
            if (score > high) {
                high = score;
                id = candidate.getId();
            }
            }
        return high >= threshold ? id : null;
    }


    public Integer find(MultipartFile image, Iterable<StudentDetail> candidates) {
        Integer id = null;
        FingerprintTemplate probe = getTemplateFromImage(image);

        return find(probe,candidates);
    }

}
