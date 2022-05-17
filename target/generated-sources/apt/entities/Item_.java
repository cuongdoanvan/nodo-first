package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Item.class)
public abstract class Item_ {

	public static volatile SingularAttribute<Item, Integer> itemId;
	public static volatile SingularAttribute<Item, String> itemName;
	public static volatile SingularAttribute<Item, Integer> itemPrice;
	public static volatile SingularAttribute<Item, String> itemDescription;

}

