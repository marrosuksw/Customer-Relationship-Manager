package com.java.clientmanager.statistics;

import com.java.clientmanager.clients.ClientCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

public class StatisticsTest {

    private final ClientCollection clientCollection = new ClientCollection();
    private final ClientCollection clientCollection2 = Mockito.mock(ClientCollection.class);


    @BeforeEach
    void setup() {
        when(clientCollection2.getClientList()).thenReturn(new ArrayList<>());
    }

}
