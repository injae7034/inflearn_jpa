package study.datajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MemberDto {

    private Long id;
    private String name;
    private String teamName;

}
