package com.jjcc.bootlaunch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Administrator
 * @version 1.0.0
 * @description
 * @className Reader.java
 * @createTime 2019年10月05日 10:29:00
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    private Long  id;
    private String author;
    private String title;
    private String content;

    @JsonFormat
    private Date createTime;

    private Reader reader;
}
