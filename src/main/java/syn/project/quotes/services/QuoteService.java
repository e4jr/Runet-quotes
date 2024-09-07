package syn.project.quotes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import syn.project.quotes.models.Quote;
import syn.project.quotes.repository.QuoteRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class QuoteService {
    @Autowired
    BashParser parser;

    @Autowired
    QuoteRepository repository;

    public List<Quote> getPage(int page) {
        List<Quote> ret = new ArrayList<>();

        try {
            Map<Integer, String> map = null;
            map = parser.getPage(page);
            for (var entry : map.entrySet()) {
                var rawQuote = new Quote();
                rawQuote.setQuoteId(entry.getKey());
                rawQuote.setText(entry.getValue());
                var existed = repository.findByQuoteIdEquals(rawQuote.getQuoteId());
                if (existed.isEmpty())
                    ret.add(repository.save(rawQuote));
                else
                    ret.add(existed.get());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ret;
    }



    public  Quote getById(int id){
        var existingQuote = repository.findByQuoteIdEquals(id);
        if (existingQuote.isPresent())
            return existingQuote.get();
        try{
            var quoteEntry = parser.getById(id);
            if (quoteEntry == null) return null;
            var newQuote = new Quote();
            newQuote.setQuoteId(quoteEntry.getKey());
            newQuote.setText(quoteEntry.getValue());
            return repository.save(newQuote);
        } catch (Exception e) {
            return null;
        }
    }




}


