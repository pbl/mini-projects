puts "How many primes?"
limit = gets.chomp.to_i
puts 'Result:'
puts ''

# primes = [2];
# (3..limit).each{ |x|
#   if(!primes.any? {|p| x % p == 0})
#     primes << x
#   end
# }
# puts primes

primes = [2]
i = 3
while primes.length < limit
  if(!primes.any? {|p| i % p == 0})
    primes << i
  end
  i += 1
end
puts 1 
puts primes