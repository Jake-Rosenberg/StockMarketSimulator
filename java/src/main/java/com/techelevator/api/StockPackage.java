
package com.techelevator.api;

import javax.annotation.Generated;
import java.util.Objects;

@Generated("jsonschema2pojo")
public class StockPackage {


    /*
    private Integer ask;
    private Integer askSize;
    private Integer averageDailyVolume10Day;
    private Integer averageDailyVolume3Month;
    private Integer bid;
    private Integer bidSize;
    private Double bookValue;
    private String currency;
    private DividendDate dividendDate;
    private EarningsTimestamp earningsTimestamp;
    private EarningsTimestampEnd earningsTimestampEnd;
    private EarningsTimestampStart earningsTimestampStart;
    private Double epsForward;
    private Double epsTrailingTwelveMonths;
    private String exchange;
    private Integer exchangeDataDelayedBy;
    private String exchangeTimezoneName;
    private String exchangeTimezoneShortName;
    private Double fiftyDayAverage;
    private Double fiftyDayAverageChange;
    private Double fiftyDayAverageChangePercent;
    private Double fiftyTwoWeekHigh;
    private Double fiftyTwoWeekHighChange;
    private Double fiftyTwoWeekHighChangePercent;
    private Double fiftyTwoWeekLow;
    private Double fiftyTwoWeekLowChange;
    private Double fiftyTwoWeekLowChangePercent;
    private String financialCurrency;
    private Double forwardPE;
    private String fullExchangeName;
    private Integer gmtOffSetMilliseconds;
    private String language;
    */
    private String longName;
    /*
    private String market;
    private Integer marketCap;
    private String marketState;
    private String messageBoardId;
    private Double postMarketChange;
    private Double postMarketChangePercent;
    private Double postMarketPrice;
    private PostMarketTime postMarketTime;
    private Integer priceHint;
    private Double priceToBook;
    private String quoteSourceName;
    private String quoteType;

     */
    private Double regularMarketChange;
    private Double regularMarketChangePercent;
    private Double regularMarketDayHigh;
    private Double regularMarketDayLow;
    private Double regularMarketOpen;
    private Double regularMarketPreviousClose;
    private Double regularMarketPrice;
    /*
    private RegularMarketTime regularMarketTime;
    private Integer regularMarketVolume;
    private Integer sharesOutstanding;
    private String shortName;
    private Integer sourceInterval;
    private String symbol;
    private Boolean tradeable;
    private Double trailingAnnualDividendRate;
    private Double trailingAnnualDividendYield;
    private Double trailingPE;
    private Double twoHundredDayAverage;
    private Double twoHundredDayAverageChange;
    private Double twoHundredDayAverageChangePercent;

     */

    /*
    public Integer getAsk() {
        return ask;
    }

    public void setAsk(Integer ask) {
        this.ask = ask;
    }

    public Integer getAskSize() {
        return askSize;
    }

    public void setAskSize(Integer askSize) {
        this.askSize = askSize;
    }

    public Integer getAverageDailyVolume10Day() {
        return averageDailyVolume10Day;
    }

    public void setAverageDailyVolume10Day(Integer averageDailyVolume10Day) {
        this.averageDailyVolume10Day = averageDailyVolume10Day;
    }

    public Integer getAverageDailyVolume3Month() {
        return averageDailyVolume3Month;
    }

    public void setAverageDailyVolume3Month(Integer averageDailyVolume3Month) {
        this.averageDailyVolume3Month = averageDailyVolume3Month;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getBidSize() {
        return bidSize;
    }

    public void setBidSize(Integer bidSize) {
        this.bidSize = bidSize;
    }

    public Double getBookValue() {
        return bookValue;
    }

    public void setBookValue(Double bookValue) {
        this.bookValue = bookValue;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public DividendDate getDividendDate() {
        return dividendDate;
    }

    public void setDividendDate(DividendDate dividendDate) {
        this.dividendDate = dividendDate;
    }

    public EarningsTimestamp getEarningsTimestamp() {
        return earningsTimestamp;
    }

    public void setEarningsTimestamp(EarningsTimestamp earningsTimestamp) {
        this.earningsTimestamp = earningsTimestamp;
    }

    public EarningsTimestampEnd getEarningsTimestampEnd() {
        return earningsTimestampEnd;
    }

    public void setEarningsTimestampEnd(EarningsTimestampEnd earningsTimestampEnd) {
        this.earningsTimestampEnd = earningsTimestampEnd;
    }

    public EarningsTimestampStart getEarningsTimestampStart() {
        return earningsTimestampStart;
    }

    public void setEarningsTimestampStart(EarningsTimestampStart earningsTimestampStart) {
        this.earningsTimestampStart = earningsTimestampStart;
    }

    public Double getEpsForward() {
        return epsForward;
    }

    public void setEpsForward(Double epsForward) {
        this.epsForward = epsForward;
    }

    public Double getEpsTrailingTwelveMonths() {
        return epsTrailingTwelveMonths;
    }

    public void setEpsTrailingTwelveMonths(Double epsTrailingTwelveMonths) {
        this.epsTrailingTwelveMonths = epsTrailingTwelveMonths;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public Integer getExchangeDataDelayedBy() {
        return exchangeDataDelayedBy;
    }

    public void setExchangeDataDelayedBy(Integer exchangeDataDelayedBy) {
        this.exchangeDataDelayedBy = exchangeDataDelayedBy;
    }

    public String getExchangeTimezoneName() {
        return exchangeTimezoneName;
    }

    public void setExchangeTimezoneName(String exchangeTimezoneName) {
        this.exchangeTimezoneName = exchangeTimezoneName;
    }

    public String getExchangeTimezoneShortName() {
        return exchangeTimezoneShortName;
    }

    public void setExchangeTimezoneShortName(String exchangeTimezoneShortName) {
        this.exchangeTimezoneShortName = exchangeTimezoneShortName;
    }

    public Double getFiftyDayAverage() {
        return fiftyDayAverage;
    }

    public void setFiftyDayAverage(Double fiftyDayAverage) {
        this.fiftyDayAverage = fiftyDayAverage;
    }

    public Double getFiftyDayAverageChange() {
        return fiftyDayAverageChange;
    }

    public void setFiftyDayAverageChange(Double fiftyDayAverageChange) {
        this.fiftyDayAverageChange = fiftyDayAverageChange;
    }

    public Double getFiftyDayAverageChangePercent() {
        return fiftyDayAverageChangePercent;
    }

    public void setFiftyDayAverageChangePercent(Double fiftyDayAverageChangePercent) {
        this.fiftyDayAverageChangePercent = fiftyDayAverageChangePercent;
    }

    public Double getFiftyTwoWeekHigh() {
        return fiftyTwoWeekHigh;
    }

    public void setFiftyTwoWeekHigh(Double fiftyTwoWeekHigh) {
        this.fiftyTwoWeekHigh = fiftyTwoWeekHigh;
    }

    public Double getFiftyTwoWeekHighChange() {
        return fiftyTwoWeekHighChange;
    }

    public void setFiftyTwoWeekHighChange(Double fiftyTwoWeekHighChange) {
        this.fiftyTwoWeekHighChange = fiftyTwoWeekHighChange;
    }

    public Double getFiftyTwoWeekHighChangePercent() {
        return fiftyTwoWeekHighChangePercent;
    }

    public void setFiftyTwoWeekHighChangePercent(Double fiftyTwoWeekHighChangePercent) {
        this.fiftyTwoWeekHighChangePercent = fiftyTwoWeekHighChangePercent;
    }

    public Double getFiftyTwoWeekLow() {
        return fiftyTwoWeekLow;
    }

    public void setFiftyTwoWeekLow(Double fiftyTwoWeekLow) {
        this.fiftyTwoWeekLow = fiftyTwoWeekLow;
    }

    public Double getFiftyTwoWeekLowChange() {
        return fiftyTwoWeekLowChange;
    }

    public void setFiftyTwoWeekLowChange(Double fiftyTwoWeekLowChange) {
        this.fiftyTwoWeekLowChange = fiftyTwoWeekLowChange;
    }

    public Double getFiftyTwoWeekLowChangePercent() {
        return fiftyTwoWeekLowChangePercent;
    }

    public void setFiftyTwoWeekLowChangePercent(Double fiftyTwoWeekLowChangePercent) {
        this.fiftyTwoWeekLowChangePercent = fiftyTwoWeekLowChangePercent;
    }

    public String getFinancialCurrency() {
        return financialCurrency;
    }

    public void setFinancialCurrency(String financialCurrency) {
        this.financialCurrency = financialCurrency;
    }

    public Double getForwardPE() {
        return forwardPE;
    }

    public void setForwardPE(Double forwardPE) {
        this.forwardPE = forwardPE;
    }

    public String getFullExchangeName() {
        return fullExchangeName;
    }

    public void setFullExchangeName(String fullExchangeName) {
        this.fullExchangeName = fullExchangeName;
    }

    public Integer getGmtOffSetMilliseconds() {
        return gmtOffSetMilliseconds;
    }

    public void setGmtOffSetMilliseconds(Integer gmtOffSetMilliseconds) {
        this.gmtOffSetMilliseconds = gmtOffSetMilliseconds;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

     */

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }
/*
    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public Integer getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Integer marketCap) {
        this.marketCap = marketCap;
    }

    public String getMarketState() {
        return marketState;
    }

    public void setMarketState(String marketState) {
        this.marketState = marketState;
    }

    public String getMessageBoardId() {
        return messageBoardId;
    }

    public void setMessageBoardId(String messageBoardId) {
        this.messageBoardId = messageBoardId;
    }

    public Double getPostMarketChange() {
        return postMarketChange;
    }

    public void setPostMarketChange(Double postMarketChange) {
        this.postMarketChange = postMarketChange;
    }

    public Double getPostMarketChangePercent() {
        return postMarketChangePercent;
    }

    public void setPostMarketChangePercent(Double postMarketChangePercent) {
        this.postMarketChangePercent = postMarketChangePercent;
    }

    public Double getPostMarketPrice() {
        return postMarketPrice;
    }

    public void setPostMarketPrice(Double postMarketPrice) {
        this.postMarketPrice = postMarketPrice;
    }

    public PostMarketTime getPostMarketTime() {
        return postMarketTime;
    }

    public void setPostMarketTime(PostMarketTime postMarketTime) {
        this.postMarketTime = postMarketTime;
    }

    public Integer getPriceHint() {
        return priceHint;
    }

    public void setPriceHint(Integer priceHint) {
        this.priceHint = priceHint;
    }

    public Double getPriceToBook() {
        return priceToBook;
    }

    public void setPriceToBook(Double priceToBook) {
        this.priceToBook = priceToBook;
    }

    public String getQuoteSourceName() {
        return quoteSourceName;
    }

    public void setQuoteSourceName(String quoteSourceName) {
        this.quoteSourceName = quoteSourceName;
    }

    public String getQuoteType() {
        return quoteType;
    }

    public void setQuoteType(String quoteType) {
        this.quoteType = quoteType;
    }


 */
    public Double getRegularMarketChange() {
        return regularMarketChange;
    }

    public void setRegularMarketChange(Double regularMarketChange) {
        this.regularMarketChange = regularMarketChange;
    }

    public Double getRegularMarketChangePercent() {
        return regularMarketChangePercent;
    }

    public void setRegularMarketChangePercent(Double regularMarketChangePercent) {
        this.regularMarketChangePercent = regularMarketChangePercent;
    }

    public Double getRegularMarketDayHigh() {
        return regularMarketDayHigh;
    }

    public void setRegularMarketDayHigh(Double regularMarketDayHigh) {
        this.regularMarketDayHigh = regularMarketDayHigh;
    }

    public Double getRegularMarketDayLow() {
        return regularMarketDayLow;
    }

    public void setRegularMarketDayLow(Double regularMarketDayLow) {
        this.regularMarketDayLow = regularMarketDayLow;
    }

    public Double getRegularMarketOpen() {
        return regularMarketOpen;
    }

    public void setRegularMarketOpen(Double regularMarketOpen) {
        this.regularMarketOpen = regularMarketOpen;
    }

    public Double getRegularMarketPreviousClose() {
        return regularMarketPreviousClose;
    }

    public void setRegularMarketPreviousClose(Double regularMarketPreviousClose) {
        this.regularMarketPreviousClose = regularMarketPreviousClose;
    }

    public Double getRegularMarketPrice() {
        return regularMarketPrice;
    }

    public void setRegularMarketPrice(Double regularMarketPrice) {
        this.regularMarketPrice = regularMarketPrice;
    }
/*
    public RegularMarketTime getRegularMarketTime() {
        return regularMarketTime;
    }

    public void setRegularMarketTime(RegularMarketTime regularMarketTime) {
        this.regularMarketTime = regularMarketTime;
    }

    public Integer getRegularMarketVolume() {
        return regularMarketVolume;
    }

    public void setRegularMarketVolume(Integer regularMarketVolume) {
        this.regularMarketVolume = regularMarketVolume;
    }

    public Integer getSharesOutstanding() {
        return sharesOutstanding;
    }

    public void setSharesOutstanding(Integer sharesOutstanding) {
        this.sharesOutstanding = sharesOutstanding;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Integer getSourceInterval() {
        return sourceInterval;
    }

    public void setSourceInterval(Integer sourceInterval) {
        this.sourceInterval = sourceInterval;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Boolean getTradeable() {
        return tradeable;
    }

    public void setTradeable(Boolean tradeable) {
        this.tradeable = tradeable;
    }

    public Double getTrailingAnnualDividendRate() {
        return trailingAnnualDividendRate;
    }

    public void setTrailingAnnualDividendRate(Double trailingAnnualDividendRate) {
        this.trailingAnnualDividendRate = trailingAnnualDividendRate;
    }

    public Double getTrailingAnnualDividendYield() {
        return trailingAnnualDividendYield;
    }

    public void setTrailingAnnualDividendYield(Double trailingAnnualDividendYield) {
        this.trailingAnnualDividendYield = trailingAnnualDividendYield;
    }

    public Double getTrailingPE() {
        return trailingPE;
    }

    public void setTrailingPE(Double trailingPE) {
        this.trailingPE = trailingPE;
    }

    public Double getTwoHundredDayAverage() {
        return twoHundredDayAverage;
    }

    public void setTwoHundredDayAverage(Double twoHundredDayAverage) {
        this.twoHundredDayAverage = twoHundredDayAverage;
    }

    public Double getTwoHundredDayAverageChange() {
        return twoHundredDayAverageChange;
    }

    public void setTwoHundredDayAverageChange(Double twoHundredDayAverageChange) {
        this.twoHundredDayAverageChange = twoHundredDayAverageChange;
    }

    public Double getTwoHundredDayAverageChangePercent() {
        return twoHundredDayAverageChangePercent;
    }

    public void setTwoHundredDayAverageChangePercent(Double twoHundredDayAverageChangePercent) {
        this.twoHundredDayAverageChangePercent = twoHundredDayAverageChangePercent;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.symbol == null)? 0 :this.symbol.hashCode()));
        result = ((result* 31)+((this.dividendDate == null)? 0 :this.dividendDate.hashCode()));
        result = ((result* 31)+((this.twoHundredDayAverageChangePercent == null)? 0 :this.twoHundredDayAverageChangePercent.hashCode()));
        result = ((result* 31)+((this.fiftyTwoWeekLowChangePercent == null)? 0 :this.fiftyTwoWeekLowChangePercent.hashCode()));
        result = ((result* 31)+((this.language == null)? 0 :this.language.hashCode()));
        result = ((result* 31)+((this.earningsTimestampEnd == null)? 0 :this.earningsTimestampEnd.hashCode()));
        result = ((result* 31)+((this.epsForward == null)? 0 :this.epsForward.hashCode()));
        result = ((result* 31)+((this.regularMarketDayHigh == null)? 0 :this.regularMarketDayHigh.hashCode()));
        result = ((result* 31)+((this.twoHundredDayAverageChange == null)? 0 :this.twoHundredDayAverageChange.hashCode()));
        result = ((result* 31)+((this.askSize == null)? 0 :this.askSize.hashCode()));
        result = ((result* 31)+((this.twoHundredDayAverage == null)? 0 :this.twoHundredDayAverage.hashCode()));
        result = ((result* 31)+((this.bookValue == null)? 0 :this.bookValue.hashCode()));
        result = ((result* 31)+((this.fiftyTwoWeekHighChange == null)? 0 :this.fiftyTwoWeekHighChange.hashCode()));
        result = ((result* 31)+((this.marketCap == null)? 0 :this.marketCap.hashCode()));
        result = ((result* 31)+((this.fiftyDayAverageChange == null)? 0 :this.fiftyDayAverageChange.hashCode()));
        result = ((result* 31)+((this.averageDailyVolume3Month == null)? 0 :this.averageDailyVolume3Month.hashCode()));
        result = ((result* 31)+((this.exchangeDataDelayedBy == null)? 0 :this.exchangeDataDelayedBy.hashCode()));
        result = ((result* 31)+((this.trailingAnnualDividendRate == null)? 0 :this.trailingAnnualDividendRate.hashCode()));
        result = ((result* 31)+((this.fiftyTwoWeekLow == null)? 0 :this.fiftyTwoWeekLow.hashCode()));
        result = ((result* 31)+((this.market == null)? 0 :this.market.hashCode()));
        result = ((result* 31)+((this.regularMarketVolume == null)? 0 :this.regularMarketVolume.hashCode()));
        result = ((result* 31)+((this.postMarketPrice == null)? 0 :this.postMarketPrice.hashCode()));
        result = ((result* 31)+((this.quoteSourceName == null)? 0 :this.quoteSourceName.hashCode()));
        result = ((result* 31)+((this.messageBoardId == null)? 0 :this.messageBoardId.hashCode()));
        result = ((result* 31)+((this.priceHint == null)? 0 :this.priceHint.hashCode()));
        result = ((result* 31)+((this.exchange == null)? 0 :this.exchange.hashCode()));
        result = ((result* 31)+((this.regularMarketDayLow == null)? 0 :this.regularMarketDayLow.hashCode()));
        result = ((result* 31)+((this.sourceInterval == null)? 0 :this.sourceInterval.hashCode()));
        result = ((result* 31)+((this.shortName == null)? 0 :this.shortName.hashCode()));
        result = ((result* 31)+((this.fiftyDayAverageChangePercent == null)? 0 :this.fiftyDayAverageChangePercent.hashCode()));
        result = ((result* 31)+((this.fullExchangeName == null)? 0 :this.fullExchangeName.hashCode()));
        result = ((result* 31)+((this.earningsTimestampStart == null)? 0 :this.earningsTimestampStart.hashCode()));
        result = ((result* 31)+((this.financialCurrency == null)? 0 :this.financialCurrency.hashCode()));
        result = ((result* 31)+((this.gmtOffSetMilliseconds == null)? 0 :this.gmtOffSetMilliseconds.hashCode()));
        result = ((result* 31)+((this.regularMarketOpen == null)? 0 :this.regularMarketOpen.hashCode()));
        result = ((result* 31)+((this.regularMarketTime == null)? 0 :this.regularMarketTime.hashCode()));
        result = ((result* 31)+((this.regularMarketChangePercent == null)? 0 :this.regularMarketChangePercent.hashCode()));
        result = ((result* 31)+((this.quoteType == null)? 0 :this.quoteType.hashCode()));
        result = ((result* 31)+((this.trailingAnnualDividendYield == null)? 0 :this.trailingAnnualDividendYield.hashCode()));
        result = ((result* 31)+((this.averageDailyVolume10Day == null)? 0 :this.averageDailyVolume10Day.hashCode()));
        result = ((result* 31)+((this.fiftyTwoWeekLowChange == null)? 0 :this.fiftyTwoWeekLowChange.hashCode()));
        result = ((result* 31)+((this.fiftyTwoWeekHighChangePercent == null)? 0 :this.fiftyTwoWeekHighChangePercent.hashCode()));
        result = ((result* 31)+((this.trailingPE == null)? 0 :this.trailingPE.hashCode()));
        result = ((result* 31)+((this.tradeable == null)? 0 :this.tradeable.hashCode()));
        result = ((result* 31)+((this.postMarketTime == null)? 0 :this.postMarketTime.hashCode()));
        result = ((result* 31)+((this.currency == null)? 0 :this.currency.hashCode()));
        result = ((result* 31)+((this.sharesOutstanding == null)? 0 :this.sharesOutstanding.hashCode()));
        result = ((result* 31)+((this.fiftyTwoWeekHigh == null)? 0 :this.fiftyTwoWeekHigh.hashCode()));
        result = ((result* 31)+((this.regularMarketPreviousClose == null)? 0 :this.regularMarketPreviousClose.hashCode()));
        result = ((result* 31)+((this.exchangeTimezoneName == null)? 0 :this.exchangeTimezoneName.hashCode()));
        result = ((result* 31)+((this.postMarketChangePercent == null)? 0 :this.postMarketChangePercent.hashCode()));
        result = ((result* 31)+((this.bidSize == null)? 0 :this.bidSize.hashCode()));
        result = ((result* 31)+((this.regularMarketChange == null)? 0 :this.regularMarketChange.hashCode()));
        result = ((result* 31)+((this.fiftyDayAverage == null)? 0 :this.fiftyDayAverage.hashCode()));
        result = ((result* 31)+((this.exchangeTimezoneShortName == null)? 0 :this.exchangeTimezoneShortName.hashCode()));
        result = ((result* 31)+((this.marketState == null)? 0 :this.marketState.hashCode()));
        result = ((result* 31)+((this.regularMarketPrice == null)? 0 :this.regularMarketPrice.hashCode()));
        result = ((result* 31)+((this.forwardPE == null)? 0 :this.forwardPE.hashCode()));
        result = ((result* 31)+((this.postMarketChange == null)? 0 :this.postMarketChange.hashCode()));
        result = ((result* 31)+((this.earningsTimestamp == null)? 0 :this.earningsTimestamp.hashCode()));
        result = ((result* 31)+((this.ask == null)? 0 :this.ask.hashCode()));
        result = ((result* 31)+((this.epsTrailingTwelveMonths == null)? 0 :this.epsTrailingTwelveMonths.hashCode()));
        result = ((result* 31)+((this.bid == null)? 0 :this.bid.hashCode()));
        result = ((result* 31)+((this.priceToBook == null)? 0 :this.priceToBook.hashCode()));
        result = ((result* 31)+((this.longName == null)? 0 :this.longName.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StockPackage) == false) {
            return false;
        }
        StockPackage rhs = ((StockPackage) other);
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.symbol == rhs.symbol)||((this.symbol!= null)&&this.symbol.equals(rhs.symbol)))&&((this.dividendDate == rhs.dividendDate)||((this.dividendDate!= null)&&this.dividendDate.equals(rhs.dividendDate))))&&((this.twoHundredDayAverageChangePercent == rhs.twoHundredDayAverageChangePercent)||((this.twoHundredDayAverageChangePercent!= null)&&this.twoHundredDayAverageChangePercent.equals(rhs.twoHundredDayAverageChangePercent))))&&((this.fiftyTwoWeekLowChangePercent == rhs.fiftyTwoWeekLowChangePercent)||((this.fiftyTwoWeekLowChangePercent!= null)&&this.fiftyTwoWeekLowChangePercent.equals(rhs.fiftyTwoWeekLowChangePercent))))&&((this.language == rhs.language)||((this.language!= null)&&this.language.equals(rhs.language))))&&((this.earningsTimestampEnd == rhs.earningsTimestampEnd)||((this.earningsTimestampEnd!= null)&&this.earningsTimestampEnd.equals(rhs.earningsTimestampEnd))))&&((this.epsForward == rhs.epsForward)||((this.epsForward!= null)&&this.epsForward.equals(rhs.epsForward))))&&((this.regularMarketDayHigh == rhs.regularMarketDayHigh)||((this.regularMarketDayHigh!= null)&&this.regularMarketDayHigh.equals(rhs.regularMarketDayHigh))))&&((this.twoHundredDayAverageChange == rhs.twoHundredDayAverageChange)||((this.twoHundredDayAverageChange!= null)&&this.twoHundredDayAverageChange.equals(rhs.twoHundredDayAverageChange))))&&((this.askSize == rhs.askSize)||((this.askSize!= null)&&this.askSize.equals(rhs.askSize))))&&((this.twoHundredDayAverage == rhs.twoHundredDayAverage)||((this.twoHundredDayAverage!= null)&&this.twoHundredDayAverage.equals(rhs.twoHundredDayAverage))))&&((this.bookValue == rhs.bookValue)||((this.bookValue!= null)&&this.bookValue.equals(rhs.bookValue))))&&((this.fiftyTwoWeekHighChange == rhs.fiftyTwoWeekHighChange)||((this.fiftyTwoWeekHighChange!= null)&&this.fiftyTwoWeekHighChange.equals(rhs.fiftyTwoWeekHighChange))))&&((this.marketCap == rhs.marketCap)||((this.marketCap!= null)&&this.marketCap.equals(rhs.marketCap))))&&((this.fiftyDayAverageChange == rhs.fiftyDayAverageChange)||((this.fiftyDayAverageChange!= null)&&this.fiftyDayAverageChange.equals(rhs.fiftyDayAverageChange))))&&((this.averageDailyVolume3Month == rhs.averageDailyVolume3Month)||((this.averageDailyVolume3Month!= null)&&this.averageDailyVolume3Month.equals(rhs.averageDailyVolume3Month))))&&((this.exchangeDataDelayedBy == rhs.exchangeDataDelayedBy)||((this.exchangeDataDelayedBy!= null)&&this.exchangeDataDelayedBy.equals(rhs.exchangeDataDelayedBy))))&&((this.trailingAnnualDividendRate == rhs.trailingAnnualDividendRate)||((this.trailingAnnualDividendRate!= null)&&this.trailingAnnualDividendRate.equals(rhs.trailingAnnualDividendRate))))&&((this.fiftyTwoWeekLow == rhs.fiftyTwoWeekLow)||((this.fiftyTwoWeekLow!= null)&&this.fiftyTwoWeekLow.equals(rhs.fiftyTwoWeekLow))))&&((this.market == rhs.market)||((this.market!= null)&&this.market.equals(rhs.market))))&&((this.regularMarketVolume == rhs.regularMarketVolume)||((this.regularMarketVolume!= null)&&this.regularMarketVolume.equals(rhs.regularMarketVolume))))&&((this.postMarketPrice == rhs.postMarketPrice)||((this.postMarketPrice!= null)&&this.postMarketPrice.equals(rhs.postMarketPrice))))&&((this.quoteSourceName == rhs.quoteSourceName)||((this.quoteSourceName!= null)&&this.quoteSourceName.equals(rhs.quoteSourceName))))&&((this.messageBoardId == rhs.messageBoardId)||((this.messageBoardId!= null)&&this.messageBoardId.equals(rhs.messageBoardId))))&&((this.priceHint == rhs.priceHint)||((this.priceHint!= null)&&this.priceHint.equals(rhs.priceHint))))&&((this.exchange == rhs.exchange)||((this.exchange!= null)&&this.exchange.equals(rhs.exchange))))&&((this.regularMarketDayLow == rhs.regularMarketDayLow)||((this.regularMarketDayLow!= null)&&this.regularMarketDayLow.equals(rhs.regularMarketDayLow))))&&((this.sourceInterval == rhs.sourceInterval)||((this.sourceInterval!= null)&&this.sourceInterval.equals(rhs.sourceInterval))))&&((this.shortName == rhs.shortName)||((this.shortName!= null)&&this.shortName.equals(rhs.shortName))))&&((this.fiftyDayAverageChangePercent == rhs.fiftyDayAverageChangePercent)||((this.fiftyDayAverageChangePercent!= null)&&this.fiftyDayAverageChangePercent.equals(rhs.fiftyDayAverageChangePercent))))&&((this.fullExchangeName == rhs.fullExchangeName)||((this.fullExchangeName!= null)&&this.fullExchangeName.equals(rhs.fullExchangeName))))&&((this.earningsTimestampStart == rhs.earningsTimestampStart)||((this.earningsTimestampStart!= null)&&this.earningsTimestampStart.equals(rhs.earningsTimestampStart))))&&((this.financialCurrency == rhs.financialCurrency)||((this.financialCurrency!= null)&&this.financialCurrency.equals(rhs.financialCurrency))))&&((this.gmtOffSetMilliseconds == rhs.gmtOffSetMilliseconds)||((this.gmtOffSetMilliseconds!= null)&&this.gmtOffSetMilliseconds.equals(rhs.gmtOffSetMilliseconds))))&&((this.regularMarketOpen == rhs.regularMarketOpen)||((this.regularMarketOpen!= null)&&this.regularMarketOpen.equals(rhs.regularMarketOpen))))&&((this.regularMarketTime == rhs.regularMarketTime)||((this.regularMarketTime!= null)&&this.regularMarketTime.equals(rhs.regularMarketTime))))&&((this.regularMarketChangePercent == rhs.regularMarketChangePercent)||((this.regularMarketChangePercent!= null)&&this.regularMarketChangePercent.equals(rhs.regularMarketChangePercent))))&&((this.quoteType == rhs.quoteType)||((this.quoteType!= null)&&this.quoteType.equals(rhs.quoteType))))&&((this.trailingAnnualDividendYield == rhs.trailingAnnualDividendYield)||((this.trailingAnnualDividendYield!= null)&&this.trailingAnnualDividendYield.equals(rhs.trailingAnnualDividendYield))))&&((this.averageDailyVolume10Day == rhs.averageDailyVolume10Day)||((this.averageDailyVolume10Day!= null)&&this.averageDailyVolume10Day.equals(rhs.averageDailyVolume10Day))))&&((this.fiftyTwoWeekLowChange == rhs.fiftyTwoWeekLowChange)||((this.fiftyTwoWeekLowChange!= null)&&this.fiftyTwoWeekLowChange.equals(rhs.fiftyTwoWeekLowChange))))&&((this.fiftyTwoWeekHighChangePercent == rhs.fiftyTwoWeekHighChangePercent)||((this.fiftyTwoWeekHighChangePercent!= null)&&this.fiftyTwoWeekHighChangePercent.equals(rhs.fiftyTwoWeekHighChangePercent))))&&((this.trailingPE == rhs.trailingPE)||((this.trailingPE!= null)&&this.trailingPE.equals(rhs.trailingPE))))&&((this.tradeable == rhs.tradeable)||((this.tradeable!= null)&&this.tradeable.equals(rhs.tradeable))))&&((this.postMarketTime == rhs.postMarketTime)||((this.postMarketTime!= null)&&this.postMarketTime.equals(rhs.postMarketTime))))&&((this.currency == rhs.currency)||((this.currency!= null)&&this.currency.equals(rhs.currency))))&&((this.sharesOutstanding == rhs.sharesOutstanding)||((this.sharesOutstanding!= null)&&this.sharesOutstanding.equals(rhs.sharesOutstanding))))&&((this.fiftyTwoWeekHigh == rhs.fiftyTwoWeekHigh)||((this.fiftyTwoWeekHigh!= null)&&this.fiftyTwoWeekHigh.equals(rhs.fiftyTwoWeekHigh))))&&((this.regularMarketPreviousClose == rhs.regularMarketPreviousClose)||((this.regularMarketPreviousClose!= null)&&this.regularMarketPreviousClose.equals(rhs.regularMarketPreviousClose))))&&((this.exchangeTimezoneName == rhs.exchangeTimezoneName)||((this.exchangeTimezoneName!= null)&&this.exchangeTimezoneName.equals(rhs.exchangeTimezoneName))))&&((this.postMarketChangePercent == rhs.postMarketChangePercent)||((this.postMarketChangePercent!= null)&&this.postMarketChangePercent.equals(rhs.postMarketChangePercent))))&&((this.bidSize == rhs.bidSize)||((this.bidSize!= null)&&this.bidSize.equals(rhs.bidSize))))&&((this.regularMarketChange == rhs.regularMarketChange)||((this.regularMarketChange!= null)&&this.regularMarketChange.equals(rhs.regularMarketChange))))&&((this.fiftyDayAverage == rhs.fiftyDayAverage)||((this.fiftyDayAverage!= null)&&this.fiftyDayAverage.equals(rhs.fiftyDayAverage))))&&((this.exchangeTimezoneShortName == rhs.exchangeTimezoneShortName)||((this.exchangeTimezoneShortName!= null)&&this.exchangeTimezoneShortName.equals(rhs.exchangeTimezoneShortName))))&&((this.marketState == rhs.marketState)||((this.marketState!= null)&&this.marketState.equals(rhs.marketState))))&&((this.regularMarketPrice == rhs.regularMarketPrice)||((this.regularMarketPrice!= null)&&this.regularMarketPrice.equals(rhs.regularMarketPrice))))&&((this.forwardPE == rhs.forwardPE)||((this.forwardPE!= null)&&this.forwardPE.equals(rhs.forwardPE))))&&((this.postMarketChange == rhs.postMarketChange)||((this.postMarketChange!= null)&&this.postMarketChange.equals(rhs.postMarketChange))))&&((this.earningsTimestamp == rhs.earningsTimestamp)||((this.earningsTimestamp!= null)&&this.earningsTimestamp.equals(rhs.earningsTimestamp))))&&((this.ask == rhs.ask)||((this.ask!= null)&&this.ask.equals(rhs.ask))))&&((this.epsTrailingTwelveMonths == rhs.epsTrailingTwelveMonths)||((this.epsTrailingTwelveMonths!= null)&&this.epsTrailingTwelveMonths.equals(rhs.epsTrailingTwelveMonths))))&&((this.bid == rhs.bid)||((this.bid!= null)&&this.bid.equals(rhs.bid))))&&((this.priceToBook == rhs.priceToBook)||((this.priceToBook!= null)&&this.priceToBook.equals(rhs.priceToBook))))&&((this.longName == rhs.longName)||((this.longName!= null)&&this.longName.equals(rhs.longName))));
    }

 */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockPackage that = (StockPackage) o;
        return Objects.equals(longName, that.longName) && Objects.equals(regularMarketChange, that.regularMarketChange) && Objects.equals(regularMarketChangePercent, that.regularMarketChangePercent) && Objects.equals(regularMarketDayHigh, that.regularMarketDayHigh) && Objects.equals(regularMarketDayLow, that.regularMarketDayLow) && Objects.equals(regularMarketOpen, that.regularMarketOpen) && Objects.equals(regularMarketPreviousClose, that.regularMarketPreviousClose) && Objects.equals(regularMarketPrice, that.regularMarketPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(longName, regularMarketChange, regularMarketChangePercent, regularMarketDayHigh, regularMarketDayLow, regularMarketOpen, regularMarketPreviousClose, regularMarketPrice);
    }
}
