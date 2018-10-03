#!/usr/bin/env ruby
require 'factory_bot'
require 'faker'

@table='intensive_data'
@registry_volume=100

class IntensiveData
	attr_accessor :description
end

FactoryBot.define do
  factory :intensive_data do
    description { Faker::BojackHorseman.quote }
  end
end

FactoryBot.build_list(:intensive_data, @registry_volume)
	.map.with_index { |data, index|
 		puts "insert into #{@table} (id, description) values (#{index}, '#{data.description}')"
	}
