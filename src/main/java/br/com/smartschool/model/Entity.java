package br.com.smartschool.model;

public abstract class Entity {

	private Long id;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return (id == null) ? -1 : id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
        if (obj == null || id == null || getClass() != obj.getClass()) return false;

        Entity entity = (Entity) obj;

        if (!id.equals(entity.id)) return false;

        return true;
	}
	
}
