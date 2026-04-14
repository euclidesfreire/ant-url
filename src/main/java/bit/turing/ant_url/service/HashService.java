package bit.turing.ant_url.service;

import java.util.ArrayList;

public class HashService {

    public String hashAlias(Long id){
        String BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        StringBuilder hash = new StringBuilder();

        Long value = id;

        while (value > 0) {
            Integer baseId = (int) (value % 62) ;

            hash.append(BASE62.charAt(baseId));

            value /= 62;
        }

        return hash.reverse().toString();
    }
}
