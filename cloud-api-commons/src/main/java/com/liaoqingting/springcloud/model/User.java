package com.liaoqingting.springcloud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author LiaoQingTing
 * @version 1.0
 * @date 2020/10/20 下午2:29
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private int     id;
    private String  name;
}

