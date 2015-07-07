class Man
  def initialize(prio_list, id)
    @pref_list = prio_list.reverse
    @id = id
  end

  def marry(women, matched)
    woman_id = '0'
    divorced_man_id = '-1'
    loop do
      woman_id = @pref_list.pop
      woman = women[woman_id]
      # require "debugger"; debugger
      divorced_man_id = woman.propose @id
      break if(divorced_man_id != '-1')
    end
    matched.put(@id, woman_id)
    return divorced_man_id
  end

  def id
    return id
  end
end