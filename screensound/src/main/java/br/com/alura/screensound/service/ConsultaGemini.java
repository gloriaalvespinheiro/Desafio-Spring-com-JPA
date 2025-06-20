package br.com.alura.screensound.service;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConsultaGemini {

    @Value("${google.gemini.api.key}")
    private  String geminiApiKey;


    public  String obterInformacao(String texto) {
        if (geminiApiKey == null || geminiApiKey.isEmpty()) {
            throw new IllegalStateException("Chave da API Gemini ausente ou inválida. Verifique 'google.gemini.api.key' em application.properties.");
        }

        ChatLanguageModel gemini = GoogleAiGeminiChatModel.builder()
                .modelName("gemini-1.5-flash")
                .apiKey(geminiApiKey)
                .build();

        String response = gemini.generate("Me fale sobre o artista: " + texto);
        return response;
    }
}
