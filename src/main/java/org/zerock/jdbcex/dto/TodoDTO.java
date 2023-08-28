package org.zerock.jdbcex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data // getter/setter/toString/equals/hashCode
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
    // 내부 구조만 보면 TodoVO와 완전히 같은 구조, 적용된 어노테이션은 차이가 있음.
    // VO는 getter만을 이용해서 읽기 전용으로 구성.
    private Long tno;

    private String title;

    private LocalDate dueDate;

    private boolean finished;
}
