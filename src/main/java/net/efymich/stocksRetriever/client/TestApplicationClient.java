package net.efymich.stocksRetriever.client;

import jakarta.validation.Valid;
import net.efymich.stocksRetriever.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "testClient", url = "localhost/api/v1")
interface TestApplicationClient {
    @GetMapping("/stock/saved")
    SavedStockDataDTO getSavedStockData(@RequestParam String ticker);

    @PostMapping("/stock/save")
    ResponseEntity<?> saveStockForUser(@RequestBody SaveStockRequest saveStockRequest);

    @PostMapping("/user/signup")
    ResponseEntity<Void> signUpUser(@Valid @RequestBody RegisterDTO request);

    @PostMapping("/user/login")
    ResponseEntity<LoginResponseDTO> loginUser(@Valid @RequestBody LoginDTO request);
}

