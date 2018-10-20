const fastify = require('fastify')();
const data = require('./data.json');

fastify.get('/intensive-processing', async (req, reply) => {
  reply.type('application/json').code(200);

  return data.filter(({ description }) => description.includes(req.query.description));
});

fastify.listen(8080, (err, address) => {
  if (err) throw err;

  fastify.log.info(`server listening on ${address}`)
});
