package dev.YGC.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class SearchControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetProductsBySearch() throws Exception {
        String productName = "Jumbo"; // Change this to your desired product name for testing
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6InJvZVYySTl4Ujl3dDBnbXFlcHhfTyJ9.eyJpc3MiOiJodHRwczovL2Rldi1vZW1wcjdoZS5ldS5hdXRoMC5jb20vIiwic3ViIjoid2JZQlpxRUdpZkpMakRuTURlcnRZbnV3R1d6amgzN3FAY2xpZW50cyIsImF1ZCI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MC9-L2FwaS8iLCJpYXQiOjE2ODY2NTIxODIsImV4cCI6MTY4NjczODU4MiwiYXpwIjoid2JZQlpxRUdpZkpMakRuTURlcnRZbnV3R1d6amgzN3EiLCJndHkiOiJjbGllbnQtY3JlZGVudGlhbHMifQ.rwSs-mt4OG0yiMRgC-1oYu3_cBxTZ0KwmHYA7lnjTQHQWsot8xjiZBx37qJZtt7-4TU2aUdSuK8tH-VN4YRe4qfrLYuAJPG1llrjdUT3FxLMGAlY-tnb_z8QA8N2fTkFvmdjkggpqbcGvlPIcBrdFA8_pEjReeeT3L0UQSbjyeGTTiwtLi_-X2dgXr2Pm8QzvM-a6iQ1nuqqxNTYC6Fj5sb1F8WeONgCmmDBVXP-Gj6oYTyu-qbhgBRinYBubcCYYQ_MEYou-6plgKlmglirMc-hclZxJvoC8oGXI1Cg0k62w6LuAltoe-nkuMFOH4kcRpjV45X2sGV6e7aVU6xTDQ"; // Change this to your authentication token


        mockMvc.perform(MockMvcRequestBuilders.post("/GetProductsBySearch")
                        .content(productName)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", "Bearer " + token))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());

//                        .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Product 1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Product 2"))
    }
}