package main.pashkouski.kiryl.p1.dao;

import main.pashkouski.kiryl.p1.domain.Manager;

public interface ManagerDAO {
	public void saveManger (Manager m);
	public Manager getManager (String lastName, String firtstName);
	public Manager getManagerByLogin (String username, String password);
	public void updateEmployee (Manager m);


}
