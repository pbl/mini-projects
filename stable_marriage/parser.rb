require_relative 'names'
require_relative 'match'

class Parser
  def initialize filename
    @filename = filename
  end

  def run
    lines = IO.readlines(@filename)
    pointer = 0
    while lines[pointer].start_with? '#'
      pointer += 1
    end
    nbr_couples = lines[pointer].split('=')
    nbr = nbr_couples[nbr_couples.length-1].to_i
    pointer += 1

    names = Names.new
    (1..nbr*2).each do
      name = lines[pointer].split(' ')
      names.add(name[0], name[1])
      pointer += 1
    end
    pointer += 1

    match = Match.new names
    count = 1
    (1..nbr).each do
      man_pref_list = lines[pointer].split(' ').slice(1, lines[pointer].length-1)
      pointer += 1
      woman_pref_list = lines[pointer].split(' ').slice(1, lines[pointer].length-1)
      pointer += 1
      match.add(man_pref_list, woman_pref_list)
      count += 1
    end
    match
  end
end
