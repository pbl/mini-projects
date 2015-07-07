require_relative "dart_board"
board = DartBoard.new
sum = 0

(2..50).step(2) do |i|
  if board.double? i
    sum += 1
  end
end

puts sum
