class Woman

  def initialize prio_list
    @prio = Hash.new
    prio_list.each_with_index do |id, index|
      @prio[id] = index
    end
    @married_to = '0';
  end

  #if she marries and dont divorces a '0'
  #if she marries and take out a divorce she returnes the divorcees id
  #if she dont marry returns -1
  def propose id
    if @married_to == '0'
      @married_to = id
      return '0'
    elsif @prio[id].to_i < @prio[@married_to].to_i
      divorcee_id = @married_to
      @married_to = id
      return divorcee_id
    else
      return '-1'
    end
  end

end