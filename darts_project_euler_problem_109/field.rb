class Field

  def initialize(number, prefix="S")
    prefix = prefix.upcase
    mult = 1;
    if prefix.eql? "D"
      mult = 2
    elsif prefix.eql? "T"
      mult = 3;
    end
    @val = number * mult
  end

  def val
    @val
  end

end