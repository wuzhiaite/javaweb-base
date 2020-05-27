package com.wuzhiaite.javaweb.common.authority.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class User implements Serializable {
   private String  id ;
   private String  userId ;
   private String  username ;
   private String  password ;
   private String  telephone ;
   private String  profilePhoto ;
   private Boolean isValidate ;
//   private List<Role> roles ;





}
