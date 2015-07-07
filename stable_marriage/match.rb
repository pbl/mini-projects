require_relative 'man'
require_relative 'woman'
require_relative 'couples'

class Match

  def initialize names
    @men = Hash.new
    @women = Array.new
    @names = names
  end

  def add(prio_list_man, prio_list_woman)
    id = @men.length*2+1
    @men[id] = Man.new(prio_list_man, id)
    @women << Woman.new(prio_list_woman)
  end

  def run
    single_men = @men.values
    couples = Couples.new(@men.length, @names)
    while !single_men.empty?
      man = single_men.pop
      divorced_man_id = man.marry(@women, couples)
      if divorced_man_id != 0
        single_men.push(@men[divorced_man_id])
      end
    end
    couples.print
  end

end