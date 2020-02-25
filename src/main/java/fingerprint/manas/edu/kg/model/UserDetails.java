package fingerprint.manas.edu.kg.model;

import com.machinezoo.sourceafis.FingerprintTemplate;
import lombok.Data;

import java.util.List;

@Data
public class UserDetails {
    private int id;
    private List<FingerprintTemplate> template;
}
