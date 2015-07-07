class NameList

  def initialize
    @names = Hash.new
  end

  def add id, name
    @names[id] = name
  end

  def get id
    return @names[id]
  end
end