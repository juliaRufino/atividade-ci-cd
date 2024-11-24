package school.sptech.atividaderelacionamento;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class AtividadeRelacionamentoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testSomarEndpoint() throws Exception {
		mockMvc.perform(get("/soma")
						.param("numero1", "10")
						.param("numero2", "20"))
				.andExpect(status().isOk())
				.andExpect(content().string("30"));
	}
}
