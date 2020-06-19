package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import flyweightexample.ConiferTree;
import flyweightexample.DeciduousTree;
import flyweightexample.Tree;
import flyweightexample.TreeFactory;

class FlyweightTest {
	private ConiferTree coniferTreeObj;
	private DeciduousTree deciduousTreeObj;
	private TreeFactory treeFactoryObj;

	@BeforeEach
	public void setUp() {
		coniferTreeObj = new ConiferTree();
		deciduousTreeObj = new DeciduousTree();
		treeFactoryObj = new TreeFactory();
	}

	@Test
	public void checkIfConiferTreeCanBeCreated() {
		assertNotNull(coniferTreeObj);
	}

	@Test
	public void checkIfDeciduousTreeCanBeCreated() {
		assertNotNull(deciduousTreeObj);
	}

	@Test
	public void checkIfTreeFactoryCanBeCreated() {
		assertNotNull(treeFactoryObj);
	}

	@Test
	public void showTheFlyweightInAction() {
		int[][] deciduousLocations = { { 1, 1 }, { 33, 50 }, { 100, 90 } };
		int[][] coniferLocations = { { 10, 87 }, { 24, 76 }, { 2, 64 } };
		Tree d, c;
		try {
			d = treeFactoryObj.getTree("deciduous");
			c = treeFactoryObj.getTree("conifer");
			for (int[] location : deciduousLocations) {
				d.display(location[0], location[1]);
			}
			for (int[] location : coniferLocations) {
				c.display(location[0], location[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
