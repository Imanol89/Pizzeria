import replace from '@rollup/plugin-replace';
import {nodeResolve} from '@rollup/plugin-node-resolve';
import commonjs from '@rollup/plugin-commonjs';
import { babel } from '@rollup/plugin-babel';
import json from '@rollup/plugin-json';
import del from 'rollup-plugin-delete';
import virtual from '@rollup/plugin-virtual';
import styles from 'rollup-plugin-styles';
import {run} from './infra/run';
import {getInput} from './infra/input';
import {onwarn} from './infra/onwarn';

const {input, virtualInput, virtualEntries} = getInput();

const client = {
    input: virtualInput,
    output: {
        dir: 'public/dist',
        format: 'es',
        sourcemap: true,
    },
    plugins: [
        del({ targets: 'public/dist/*' }),
        virtual(virtualEntries),
        replace({
            'process.env.NODE_ENV': JSON.stringify('development'),
            'process.env.CLOUD_NAME': JSON.stringify(process.env.CLOUD_NAME)
        }),
        styles({
            autoModules: true,
            sourceMap: true
        }),
        nodeResolve(
            {
            preferBuiltins: true,
        }
        ),
        commonjs({
            exclude: 'src/**/*'
        }),
        babel({
            babelHelpers: 'bundled',
            exclude: [/core-js/],
            presets: [
                '@babel/preset-react',
                [
                    '@babel/preset-env',  {
                        useBuiltIns: 'usage',
                        corejs: {version: 3},
                        targets: {
                            chrome: '88'
                        }
                    }
                ]
            ]
        })
    ]
}

const server = {
    input: {
        server: 'src/index.js',
        ...input
    },
    output: {
        dir: 'build',
        format: 'es',
        sourcemap: true,
    },
    onwarn,
    plugins: [
        del({ targets: 'build/*' }),
        replace({
            'process.env.NODE_ENV': JSON.stringify('development'),
            'process.env.CLOUD_NAME': JSON.stringify(process.env.CLOUD_NAME)
        }),
        styles({
            autoModules: true,
        }),
        json(),
        nodeResolve(
            {
            preferBuiltins: true,
        }
        ),
        commonjs({
            exclude: 'src/**/*'
        }),
        babel({
            babelHelpers: 'bundled',
            exclude: [/core-js/],
            presets: [
                '@babel/preset-react',
                [
                    '@babel/preset-env',  {
                        useBuiltIns: 'usage',
                        corejs: {version: 3},
                        targets: {
                            node: '14'
                        }
                    }
                ]
            ]
        }),
        run({name: 'server'})
    ]
}

export default [client, server]
