package com.bytetest.accountmanagerapi.genericattribue;

import jakarta.persistence.MappedSuperclass;

import java.util.Date;

@MappedSuperclass
public class Attributes {
private Date createdAt;
private Date updatedAt;

}
