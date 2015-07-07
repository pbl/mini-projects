class Man

  def initialize(prio_list, id)
    @arr = prio_list
    @pointer = 0
    @id = id
  end

  def marry(women, matched)
    woman_id = 0
    divorced_man_id = -1
    loop do
      woman_id = pop_woman
      woman = women[woman_id/2-1]
      divorced_man_id = woman.propose @id
      break if(divorced_man_id != -1)
    end
    matched.put(@id, woman_id)
    return divorced_man_id
  end

  def id
    return id
  end

  private
    def pop_woman
      id = @arr[@pointer]
      @pointer = @pointer + 1
      return id
    end
end