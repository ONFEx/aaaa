package wo.esys.po;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@Entity
@Table(name = "sys_region")
public class Region {

	private final static Logger LOG = LogManager.getLogger(Region.class);

	@Id
	@Column(length = 50)
	private String id;

	@Column(length = 30)
	private String name;

	@Column(length = 30)
	private String no;

	@Column(length = 200)
	private String description;

	public Region(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.no = id;
		this.description = description;
		if (id.indexOf('_') > 0) {
			String parentId = id.substring(0, id.lastIndexOf('_'));
			parent = new Region ();
			parent.setId(parentId);
		}
	}

	public Region() {
		super();
	}

	public Region(String id2) {
		this.id = id2;
	}

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Region parent;

	@OneToMany(mappedBy = "parent")
	private List<Region> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Region getParent() {
		return parent;
	}

	public void setParent(Region parent) {
		this.parent = parent;
	}

	public List<Region> getChildren() {
		Collections.sort(children, new Comparator<Region>() {

			@Override
			public int compare(Region o1, Region o2) {
				return o1.getNo().compareTo(o2.getNo());
			}

		});
		return children;
	}

	public void setChildren(List<Region> children) {
		this.children = children;
	}

}
