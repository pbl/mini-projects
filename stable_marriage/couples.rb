class Couples

  def initialize(length, names)
    @couples = Array.new length
    @names = names
  end

  def put(man_id, woman_id)
    @couples[(man_id.to_i)/2] = [man_id, woman_id]
  end

  def print
    result = Array.new(@couples.length)
    count = 0
    @couples.each do |x|
      result[count] = format_couple x
      count += 1
    end
    result
  end

  def format_couple pair
    man = @names.get(pair[0])
    woman = @names.get(pair[1])
    "#{man} -- #{woman}\n"
  end
end