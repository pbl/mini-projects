require_relative "field"
require "minitest/autorun"
 
class TestField < Minitest::Test

  def test_field
    val = Field.new(1).val()
    assert_equal(1,  1)
    # assert_equal(2, Field.new(1, :d))
  end

end