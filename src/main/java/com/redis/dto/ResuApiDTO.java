package com.redis.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cc
 * @date 2023/9/18-10:14
 */
@Data
public class ResuApiDTO implements Serializable {

    private static final long serialVersionUID = 751525140586146713L;

    private String apiId;

}

