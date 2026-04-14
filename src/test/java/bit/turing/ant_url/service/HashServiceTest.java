package bit.turing.ant_url.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class HashServiceTest {

    @InjectMocks
    private HashService hashService;

    @ParameterizedTest
    @ValueSource(longs = {45786584L, 400001111L, 1L, 0L, 10L, 11L})
    void shouldReturnHashAlias(Long id){
        String hash = hashService.hashAlias(id);

        System.out.println("hash: " + hash);

        assertNotNull(hash);
    }
}
