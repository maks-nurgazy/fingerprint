package fingerprint.manas.edu.kg.entity;

import lombok.Data;

@Data
public class Student {

    private String name;

    private String surname;

    private String rollNumber;

    private Faculty faculty;

}
