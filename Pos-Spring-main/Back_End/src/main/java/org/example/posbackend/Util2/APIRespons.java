package org.example.posbackend.Util2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class APIRespons<T> {
    private  int status;
    private  String message;
    private  T data;
}
