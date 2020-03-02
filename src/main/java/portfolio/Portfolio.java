package portfolio;

import portfolio.investments.Investment;

import java.util.HashSet;
import java.util.Set;

public class Portfolio<T extends Investment> {
    private Set<T> content;

    public Portfolio() {
        content = new HashSet<>();
    }

    public <I extends Investment> boolean contains(I investment) {
        return content.contains(investment);
    }

    public void buy(T investment) {
        if (!content.contains(investment)) {
            content.add(investment);
        } else {
            for (T invest : content) {
                if (invest.getTitel().equals(investment.getTitel())) {
                    invest.setCount(invest.getCount() + 1);
                    break;
                }
            }
        }

    }

    public void sell(String title, int num) {
        for (T invest : content) {
            if (invest.getTitel().equals(title)) {
                invest.setCount(invest.getCount() - num);
                if (invest.getCount() <= 0) {
                    content.remove(invest);
                }

            }
        }
    }

    public T getShare(String name) {
        for (T invest : content) {
            if (invest.getTitel().equals(name)) {
                return invest;
            }
        }
        return null;
    }
}
