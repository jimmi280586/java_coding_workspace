package system;

import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Vector;

import exceptions.StockQuoteException;
import exceptions.UnknownStockException;
import interfaces.StockQuoteClient;
import interfaces.StockQuoteServer;

public class StockQuoteServerImpl implements StockQuoteServer {

	@Override
	// addWatch adds a client to the list of clients watching a stock

    public void addWatch(StockQuoteClient client, String stock)
    throws java.rmi.RemoteException, StockQuoteException
    {

//If we don't know about the stock, throw an exception

         if (stocks.get(stock) == null) {
              throw new UnknownStockException(stock);
         }

//Get the container of clients watching this stock
         Vector clients = (Vector) stockClients.get(stock);

//If no clients are watching, create the container
         if (clients == null) {
              clients = new Vector();
              clients.addElement(client);
              stockClients.put(stock, clients);

//Only add the client if it isn't already there. We don't want to
//double-update clients.

         } else if (!clients.contains(client)) {
              clients.addElement(client);
         }
    }

	@Override
	public void removeWatch(StockQuoteClient client, String stock) throws RemoteException, StockQuoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeClient(StockQuoteClient client) throws RemoteException, StockQuoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getStockList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	// publishQuote sends a stock quote to every client who is watching

    protected void publishQuote(StockQuote quote)
    {

//Get the list of clients for the stock
         Vector v = (Vector) stockClients.get(quote.stock);

//If there are no clients, we're done
         if (v == null) return;

         Enumeration e = v.elements();

//When we get an exception sending a notification to a client, we
//remove the client. We don't do it until we've sent all the
//notifications however. We store them in badClients until then.

         Vector badClients = null;

         while (e.hasMoreElements()) {

              StockQuoteClient client = (StockQuoteClient)
                   e.nextElement();

//send the quote to the client
              try {
                   client.quote(quote);

//If we get an error, add the client to the list of bad clients

              } catch (java.rmi.RemoteException oops) {
                   if (badClients == null) {
                        badClients = new Vector();
                   }
                   badClients.addElement(client);
              }
         }

//If there were any bad clients, remove them

         if (badClients != null) {
              e = badClients.elements();
              while (e.hasMoreElements()) {
                   clearClient(
                        (StockQuoteClient) e.nextElement());
              }
         }
    }

}
