package org.zerock.springex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Arrays;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    @Builder.Default // 기본값
    @Min(value = 1)
    @Positive
    private int page = 1;

    @Builder.Default // 기본값
    @Min(value = 10)    // Min, Max -> 외부에서 조작하는 경우에 대한 대비
    @Max(value = 100)
    @Positive
    private int size = 10;

    private String link;

    private String[] types;

    private String keyword;

    private boolean finished;

    private LocalDate from;

    private LocalDate to;

    // limit에서 사용하는 건너뛰기(skip)의 개수
    public int getSkip() {
        return (page - 1) * 10;
    }

    public String getLink() {
        StringBuilder builder = new StringBuilder();
        builder.append("page=" + this.page);
        builder.append("&size=" + this.size);

        if(finished) {
            builder.append("&finished=on");
        }

        if(types != null && types.length > 0) {
            for(int i=0; i < types.length; i++) {
                builder.append("&types=" + types[i]);
            }
        }

        if(keyword != null) {
            try {
                builder.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8"));
            } catch(UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        if(from != null) {
            builder.append("&from=" + from.toString());
        }

        if(to != null) {
            builder.append("&to=" + to.toString());
        }

        return builder.toString();
    }

    // 주어진 'type'문자열이 배열 'types'내에 존재하는지 확인하는 역할
    public boolean checkType(String type) {
        if (types == null || types.length == 0) {
            return false;
        }

        // Arrays.stream(types)는 배열을 스트림으로 변환,,,
        // anyMatch(type::equals)는 스트림 내에서 주어진 조건 (type::equals)에 해당하는 요소가 하나 이상 있는지 확인
        // anyMatch는 일치하는 요소를 찾으면 true, 없으면 false를 반환함.
        return Arrays.stream(types).anyMatch(type::equals);
    }
}
