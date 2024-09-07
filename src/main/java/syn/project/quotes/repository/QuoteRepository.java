package syn.project.quotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import syn.project.quotes.models.Quote;

import java.util.Optional;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {
    Optional<Quote> findByQuoteIdEquals(Integer quoteId);

}
