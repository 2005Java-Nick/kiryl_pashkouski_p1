package main.pashkouski.kiryl.p1.dao;

import java.util.List;

import main.pashkouski.kiryl.p1.domain.Request;

public interface RequestDAO {
	public void saveRequest (Request r);
	public List<Request> getRequestList ();
}
