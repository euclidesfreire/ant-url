package bit.turing.ant_url.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class IdServiceTest {

    @InjectMocks
    private IdService idService;

    //@ParameterizedTest
    //@ValueSource(longs = {45786584L, 400001111L, 457865840001L, 1L, 0L, 10L, 11L})
    @Test
    void shouldReturnHashAlias(){
        String hash = idService.nextID();

        System.out.println("hash: " + hash);

        assertNotNull(hash);
    }

    @Test
    void CollisionHashAlias(){
        Long[] ids = {45786584L, 45786584L, 457865840001L, 457865840001L, 1L, 1L};
        HashSet<String> aliasSet = new HashSet<>();

        for ( Long id : ids ){
            Boolean aliasExist = true;

            String alias = "";

            do {
                alias = idService.nextID();
                aliasExist = aliasSet.add(alias);
                System.out.println("hash: " + alias);
            } while (!aliasExist);
        }

        //assertNotNull(aliasSet.isEmpty());
    }
}
