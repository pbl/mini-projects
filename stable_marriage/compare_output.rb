class CompareOutput
  def initialize
  end

  def run(result, file_out)
    equal = true
    file = File.open file_out
    result.each do |line|
      file_line = file.gets
      if !(line.eql? file_line)
        equal = false
      end
    end
    equal
  end
end