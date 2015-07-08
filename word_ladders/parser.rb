class Parser
  def initialize file
    @file = file
  end

  def get_dat
    line_proc = Proc.new {|line| line.chomp }
    @dat_words = parse_file("#{@file}.dat", line_proc)
  end

  def get_in
    line_proc = Proc.new {|line| line.chomp.split(' ') }
    parse_file("#{@file}-test.in", line_proc)
  end

  private
    def parse_file(file, a_proc)
      words = Array.new
      File.readlines(file).each do |line|
        words << a_proc.call(line)
      end
      words
    end
end

# def sort str
#   str.chars.sort.join
# end

# def uniq_words file
#   words = Array.new
#   File.readlines(file).each do |line|
#     words << sort(line.chomp)
#   end
# end

# def uniq_last_letters file
#   letters = Array.new
#   File.readlines(file).each do |line|
#     line = line.slice(1, line.length)
#     letters << sort(line.chomp)
#   end
#   # puts letters.sort
# end

# def uniq_ratio words
#   puts nbr_words = words.length
#   puts uniq_words = words.uniq.length
#   puts "ratio is #{uniq_words.to_f/nbr_words.to_f}"
# end
