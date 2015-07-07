require_relative 'man'
require_relative 'woman'
require_relative 'couples'

class Match

  def initialize names
    @men = Hash.new
    @women = Hash.new
    @names = names
    @id = 1
  end

  def add(prio_list_man, prio_list_woman)
    @men[@id.to_s] = Man.new(prio_list_man, @id.to_s)
    @id += 1
    @women[@id.to_s] = Woman.new(prio_list_woman)
    @id += 1
  end

  def run
    single_men = @men.values
    couples = Couples.new(@men.length, @names)
    while !single_men.empty?
      man = single_men.pop
      divorced_man_id = man.marry(@women, couples)
      if divorced_man_id.to_i != 0
        single_men.push(@men[divorced_man_id])
      end
    end
    couples.print
  end

end