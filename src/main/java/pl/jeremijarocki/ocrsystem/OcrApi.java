package pl.jeremijarocki.ocrsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OcrApi {

    private OcrService ocrService;
    private GraphicRepository graphicRepository;

    @Autowired
    public OcrApi (OcrService ocrService, GraphicRepository graphicRepository) {
        this.ocrService = ocrService;
        this.graphicRepository = graphicRepository;
    }

    @PostMapping("/api/ocr")
    public String doOcr (@RequestBody Graphic graphic) {
        String ocr = ocrService.doOCR(graphic.getUrl());
        graphic.setContent(ocr);
        graphicRepository.save(graphic);
        return ocr;
    }

    @GetMapping("/api/ocr")
    public Iterable<Graphic> getGraphic () {
        return graphicRepository.findAll();
    }
}
