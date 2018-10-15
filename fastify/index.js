const fs = require('fs');
const { promisify } = require('util');
const readFileAsync = promisify(fs.readFile);
const fastify = require('fastify')();

fastify.get('/intensive-processing', async (req, reply) => {
  reply.type('application/json').code(200);

  const data = JSON.parse(await readFileAsync('./data.json', { encoding: 'utf8' }));

  return data.filter(({ description }) => description.includes(req.query.description));
});

fastify.listen(8080, (err, address) => {
  if (err) throw err;

  fastify.log.info(`server listening on ${address}`)
});
