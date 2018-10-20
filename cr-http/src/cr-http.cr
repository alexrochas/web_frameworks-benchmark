require "json"
require "http/server"

module Cr::Http
  VERSION = "0.1.0"

  class JSONData
    JSON.mapping(
      id: Int32,
      description: String
    )
  end

  file = File.read "./data.json"
  items = Array(JSONData).from_json file

  server = HTTP::Server.new do |context|
    context.response.content_type = "application/json"

    if context.request.query_params.has_key?("description")
      filteredItems = items.select do |data|
        data.description.includes?(context.request.query_params["description"])
      end

      context.response.print filteredItems.to_json
    else
      context.response.print Array(JSONData).new
    end
  end

  address = server.bind_tcp 8080
  puts "Listening on http://#{address}"
  server.listen
end
