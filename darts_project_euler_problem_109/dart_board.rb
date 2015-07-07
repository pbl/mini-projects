class DartBoard

  def initialize
    @h = Hash.new
    for i in 1..60
      @h[i] = [[],[],[]]
    end

    for i in 1..20
      s = Field.new(i)
      add_field(0, s)
      d = Field.new(i, "d")
      add_field(1, d)
      t = Field.new(i, "t")
      add_field(2, t)
    end
    b = Field.new(25)
    add_field(0, b)
    bd = Field.new(25, "d")
    add_field(1, bd)
  end

  def any? score
  end

  def amount score
  end

  def double? score
    @h[score][1].size > 0
  end


  private
    def add_field(pos, field)
      points_possibilites = @h[field.val()][pos]
      points_possibilites << field
    end


  class Field
    def initialize(number, type="S")
      type = type.upcase
      mult = 1;
      if type.eql? "D"
        mult = 2
      elsif type.eql? "T"
        mult = 3;
      end
      @val = number * mult
    end

    def val
      @val
    end

  end
end