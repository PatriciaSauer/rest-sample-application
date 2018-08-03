package com.psauer.rest.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@JsonInclude(Include.NON_NULL)
public class User {

  @Id
  private String id;

  private String username;

  @JsonProperty("eMailAddress")
  private String eMailAddress;

}
