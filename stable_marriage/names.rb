class Names

  def initialize
    @name_map = Hash.new
  end

  def add(id, name)
    @name_map[id] = name
  end

  def get id
    @name_map[id]
  end
end